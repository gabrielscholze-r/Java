
public class RecursaoFatorial {
	public static void main(String[] args) {
	    RecursaoFatorial r = new RecursaoFatorial();
	    int resp = r.fatorial(3);
	    int resp1 = r.fatorial(4);
	    int resp2 = r.fatorial(5);
	    
	    System.out.println(resp);
	    System.out.println(resp1);
	    System.out.println(resp2);
	  }
	  public int fatorial(int x) {
	    if (x == 0)
	      return 1;
	    return x * fatorial(x - 1);
	  }
}
