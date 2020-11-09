package daoservices;



public interface DaoGenerics<T>{
	
	

	public void insertObject(T object);
	
	public void findAndPrint(T object);
	
	public void findAndModify(T object);

}
