class Card {
	final String KIND; 
    final int NUMBER;  
        
    static int width  = 100; 
    static int height = 250; 
    
    Card(String kind, int num) {
    	KIND = kind;
    	NUMBER = num;
    }
    
    Card() {
    	this("HEART", 1);
    }
    
    public String toString() {
    	return KIND + " "+ NUMBER;
    }
}

class FinalCardTest {
	public static void main(String[] args) {
		Card c = new Card("HEART", 10);
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);

	}
}
