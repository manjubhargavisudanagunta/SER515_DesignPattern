package PTBS;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Buyer extends Person {
	
	Buyer(ProductMenu theProductMenu){
		super(theProductMenu);
	}

	public void showMenu() {
		System.out.print("Product Menu For Buyer");
		
	}

	public ProductMenu CreateProductMenu(Object Obj, String SelectProduct,String ProductLevel) {
	Map<Object ,Set<String>> BuyerProduct = new HashMap<Object,Set<String>>();
	Set<String> setP = new HashSet<String>();
	setP.add((SelectProduct.concat("-")).concat(ProductLevel));
	BuyerProduct.put(Obj, setP);
	System.out.println(" ");
	System.out.println("Sample Output: "+BuyerProduct);
	return null;
	}

}
