package PTBS;
import java.util.HashMap;
public class ProductIterator {

	@SuppressWarnings("unused")
	private ClassProductList classProductList;
	int max_prod = 20;
	String[] Prodlist;
	int initial = 0;

	public ProductIterator(String[] productList) {
		Prodlist = new String[max_prod];
		int i = 0;
		for(int k=0; k<productList.length; k++) {
			Prodlist[i] = productList[k];
		    if(i<max_prod)
		    	i++;
		}
	}

	public boolean hasNext() {
		if(initial < Prodlist.length &&
				Prodlist[initial] != null)
			return true;
		else
			return false;
	}

	public Product Next() {
		return null;
	}

	public void MoveToHead() {

	}

	public void Remove() {

	}

	public void createIterator() {
		// TODO Auto-generated method stub
		
	}

	public HashMap<Integer,String> next() {
		String productName = Prodlist[initial];
		initial +=1;
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		map.put(initial, productName);
		return map;
	}

}
