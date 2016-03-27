package skeleton;

/**
 * @brief Ez a class felelős azért, hogy a
 * kimeneten a megfelelő mennyiségű tabot kiprintelje
 */
public class Depth
{
	private int depth = 0;
	private static Depth instance = null;
	
	public static Depth getInstance(){
		if(instance == null){
			instance = new Depth();
		}
		
		return instance;
	}
	
	public void enterFunction(){
		depth++;
	}
	
	public void returnFromFunction(){
		depth--;
	}
	
	public void printTabs(){
		for(int i=0;i < depth;i++)
		{System.out.print("\t");}
	}
}