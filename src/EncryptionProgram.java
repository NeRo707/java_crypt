import java.util.*;

public class EncryptionProgram {

  private Scanner sc;
  private ArrayList<Character> list;
  private ArrayList<Character> shf_list;
  private char c;
  private char[] letters;

  EncryptionProgram() {
    sc = new Scanner(System.in);
    list = new ArrayList<>();
    shf_list = new ArrayList<>();
    c = ' ';
    newKey();
    ask();
  };

  private void ask() {
    while (true) {
      System.out.println("What do you want to do?");
      System.out.println("N. New key, G. Get key, E. Encrypt, D. Decrypt, Q. Quit");
      char res = Character.toUpperCase(sc.nextLine().charAt(0));
      switch (res) {
        case 'N':
          newKey();
          break;
        case 'G':
          getKey();
          break;
        case 'E':
          encrypt();
          break;
        case 'D':
          decrypt();
          break;
        case 'Q':
          quit();
          break;
        default:
          break;
      }
    }
  };

  private void newKey() {

    c = ' ';
    list.clear();
    shf_list.clear();

    for (int k = 32; k < 127; k++) {
      list.add(Character.valueOf(c));
      c++;
    }

    shf_list = new ArrayList<>(list);
    Collections.shuffle(shf_list);

    System.out.println("*New Key Generated*");
  };

  private void getKey() {
    System.out.println("Key: ");

    for (Character ch : list) {
      System.out.print(ch);
    }
    System.out.println();

    for (Character ch : shf_list) {
      System.out.print(ch);
    }
    System.out.println();
  };

  private void encrypt() {
    System.out.println("Enter text to encrypt: ");
    String text = sc.nextLine();

    letters = text.toCharArray();

    for (int k = 0; k < letters.length; k++) {
      for (int j = 0; j < list.size(); j++) {
        if (letters[k] == list.get(j)) {
          letters[k] = shf_list.get(j);
          break;
        }
      }
    }
    System.out.println("Encrypted text: " + new String(letters));
  };

  private void decrypt() {
    System.out.println("Enter text to be decrypted: ");
    String text = sc.nextLine();

    letters = text.toCharArray();

    for (int k = 0; k < letters.length; k++) {
      for (int j = 0; j < shf_list.size(); j++) {
        if (letters[k] == shf_list.get(j)) {
          letters[k] = list.get(j);
          break;
        }
      }
    }
    System.out.println("Decrypted text: " + new String(letters));
  };

  private void quit() {
    System.out.println("Bye!");
    sc.close();
    System.exit(0);
  };

}
