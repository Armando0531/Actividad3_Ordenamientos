class MetodosOrdenamiento{
	public long[] ordenarIntercalacion(int primero[],int[] segundo){
		long arrayOrdenado[]=new long[primero.length+segundo.length];
		int i=0,j=0,k=0;
	
		while(i<primero.length && j<segundo.length) {
			if(primero[i]<segundo[j]) {
				arrayOrdenado[k]=primero[i];
				i++;
			}else {
				arrayOrdenado[k]=primero[j];
				j++;
			}
			k++;
		}
		while(j<segundo.length) {
			arrayOrdenado[k]=segundo[j];
			j++;
			k++;
		}
		while(i<primero.length) {
			arrayOrdenado[k]=segundo[i];
			i++;
			k++;
		}
		return arrayOrdenado;
		
	}
}
public class PruebaOrdenamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
