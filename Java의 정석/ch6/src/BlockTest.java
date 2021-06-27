class BlockTest {
	static {
		System.out.println("statc {}");
	}
	
	{
		System.out.println("{ }");
	}
	
	public static void main(String[] args) {
		System.out.println("BlockTest bt = new BlockTest(); ");
		BlockTest bt = new BlockTest();
		System.out.println("BlockTest bt2 = new BlockTest(); ");
		BlockTest bt2 = new BlockTest();
	
	}

}
