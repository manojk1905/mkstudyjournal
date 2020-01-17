package features.java9;

class Resource implements AutoCloseable {
	public void close() throws Exception {
		System.out.println("closing..");
	}
}