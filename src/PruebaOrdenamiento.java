import java.util.Arrays;
import java.util.Scanner;

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

class pruebasEstres{
	
	public void pruebaEstres(String op) {
		int vector1000elementos[]=new int[1000];
		int vector10000elementos[]=new int[10000];
		int vector100000elementos[]=new int[100000];
		int vector1000000elementos[]=new int[1000000];
		//System.out.println("Acabo el 1");
		for(int i=0;i<vector1000elementos.length;i++) {
			vector1000elementos[i]=(int) (Math.random() * 1000 + 1);
		}
		//System.out.println("Acabo el 2");
		for(int i=0;i<vector10000elementos.length;i++) {
			vector10000elementos[i]=(int) (Math.random() * 10000 + 1);
		}
		//System.out.println("Acabo el 3");
		for(int i=0;i<vector100000elementos.length;i++) {
			vector100000elementos[i]=(int) (Math.random() * 10000 + 1);
		}
		//System.out.println("Acabo el 4");
		for(int i=0;i<vector1000000elementos.length;i++) {
			vector1000000elementos[i]=(int) (Math.random() * 100000 + 1);
		}
		int numerosDesordenados[]= {55,15,78,99,16,1,112,23,1789};
		int copi[];
		if(op.equalsIgnoreCase("1")) {
			pruebaEstres(numerosDesordenados);
		}else if (op.equalsIgnoreCase("2")) {
			pruebaEstres(vector1000elementos);
		}
		else if (op.equalsIgnoreCase("3")) {
			pruebaEstres(vector10000elementos);
		}
		else if (op.equalsIgnoreCase("4")) {
			pruebaEstres(vector100000elementos);
		}
		else if (op.equalsIgnoreCase("5")) {
			pruebaEstres(vector1000000elementos);
		}
	}
	public void pruebaEstres(int vector[]) {
		MetodosOrdenamiento orden=new MetodosOrdenamiento();
		long tTnicio,tFin;
		int copi[];
		System.out.println("Pruebas estres intercalacion");
		int cantidad1=0;
		int cantidad2=0;
		int c=0;
		cantidad1=(int) (Math.random() * vector.length);
		cantidad2=vector.length-cantidad1;
		int v1[]=new int[cantidad1];
		int v2[]=new int[cantidad2];
		for(int i=0;i<cantidad1;i++) {
			v1[i]=vector[c];
			c++;
		}
		for(int i=0;i<cantidad2;i++) {
			v2[i]=vector[c];
			c++;
		}
		//System.out.println(Arrays.toString(v1));
		//System.out.println(Arrays.toString(v2));
		copi=null;
		tFin=tTnicio=0;
		copi=Arrays.copyOf(vector,vector.length-1);
		v1=orden.ordenamientoMezclaDirecto(v1);
		v1=orden.ordenamientoMezclaDirecto(v2);
		tTnicio=System.nanoTime();
		orden.ordenarIntercalacion(v1, v2);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("-------------------- Mezcla directa ---------------------------");
		copi=null;
		tFin=tTnicio=0;
		copi=Arrays.copyOf(vector,vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenamientoMezclaDirecto(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		System.out.println("--------------------Mezcla Natural---------------------------");
		copi=null;
		tFin=tTnicio=0;
		copi=Arrays.copyOf(vector,vector.length-1);
		tTnicio=System.nanoTime();
		orden.ordenamientoMezclaNatural(copi);
		tFin=System.nanoTime();
		System.out.println("Tardo: "+(tFin-tTnicio));
		orden.mostrarContador();
		}
}

public class PruebaOrdenamiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
