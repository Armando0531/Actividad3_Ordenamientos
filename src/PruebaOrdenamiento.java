class MetodosOrdenamiento{
	
	int [] contador=new int[3];
	public void mostrarContador() {
		System.out.println("Numero de recorridos-> "+contador[0]);
		System.out.println("Numero de Intercambios-> "+contador[1]);
		System.out.println("Numero de Comparaciones-> "+contador[2]);
		contador[0]=0;
		contador[1]=0;
		contador[2]=0;
	}
	
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
	
	public int [] ordenamientoMezclaDirecto(int arreglo[]) {
		int i,j,k;
		contador[2]++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
			
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				contador[0]++;
			}
			
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				contador[0]++;
			}
			
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {
				contador[2]++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					contador[1]++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					contador[1]++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				contador[0]++;
			}
			
			while(arregloIzquierdo.length!=j) {
				contador[1]++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				contador[0]++;
			}
			
			while(arregloDerecha.length!=k) {
				contador[1]++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				contador[0]++;
			}
		}
		
		return arreglo;
	}
	
	public void ordenamientoMezclaDirecto1(int arreglo[]) {
		int i,j,k;
		contador[2]++;
		if(arreglo.length>1) {
			int numElementosIzq=arreglo.length/2;
			int numElmentosDer=arreglo.length-numElementosIzq;
			
			int arregloIzquierdo[]=new int[numElementosIzq];
			int arregloDerecha[]=new int[numElmentosDer];
			
			for(i=0;i<numElementosIzq;i++) {
				arregloIzquierdo[i]=arreglo[i];
				contador[0]++;
			}
			
			i=0;
			for(i=numElementosIzq;i<numElementosIzq+numElmentosDer;i++) {
				arregloDerecha[i-numElementosIzq]=arreglo[i];
				contador[0]++;
			}
			
			arregloIzquierdo=ordenamientoMezclaDirecto(arregloIzquierdo);
			arregloDerecha=ordenamientoMezclaDirecto(arregloDerecha);
			i=j=k=0;
			
			while(arregloIzquierdo.length!=j && arregloDerecha.length!=k) {
				contador[2]++;
				if(arregloIzquierdo[j]<arregloDerecha[k]) {
					contador[1]++;
					arreglo[i]=arregloIzquierdo[j];
					i++;
					j++;
				}else {
					contador[1]++;
					arreglo[i]=arregloDerecha[k];
					i++;
					k++;
				}
				contador[0]++;
			}
			
			while(arregloIzquierdo.length!=j) {
				contador[1]++;
				arreglo[i]=arregloIzquierdo[j];
				i++;
				j++;
				contador[0]++;
			}
			
			while(arregloDerecha.length!=k) {
				contador[1]++;
				arreglo[i]=arregloDerecha[k];
				i++;
				k++;
				contador[0]++;
			}
		}
		
	}
	
	public void ordenamientoMezclaNatural(int [] numeros) {
		int izquierda =0;
		int izq =0;
		int derecha = numeros.length-1;
		int der = derecha;
		boolean ordenado = false;
		
		long ini = System.nanoTime();
		do {
			ordenado = true;
			izquierda = 0;
			while(izquierda<derecha) {
				izq =izquierda;
				while(izq < derecha && numeros[izq]<=numeros[izq+1]) {
					izq++;
					contador[0]++;
				}
				der = izq +1;
				while(der==derecha-1 || der<derecha && numeros[der]<=numeros[der+1]) {
					der++;
					contador[0]++;
				}
				contador[2]++;
				if(der<=derecha) {
					ordenamientoMezclaDirecto1(numeros);
					
					ordenado = false;
				}
				izquierda=izq;
				contador[0]++;
			}
			contador[0]++;
		}while(!ordenado);
		
		
	
	}
}

public class PruebaOrdenamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
