package Model;

public class Matrices {
	/**
	 * Variable que almacena la matriz A
	 */
	private long[][] A;
	/**
	 * Variable que almacena la matriz B
	 */
	private long[][] B;
	/**
	 * Variable que almacena la matriz C
	 */
	private long[][] C;
	/**
	 * Metodo que crea un objeto de la clase Matrices <br>
	 * <b>Pre:</b> <br>
	 * Las librerias estan correctamente incluidas en el proyecto <br>
	 * <b>Post:</b> <br>
	 * Se inicializaron las ventanas, clases, botones, checkbox y se muestra window.
	 */
	public Matrices() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo que se encarga de validar la matriz de mayor tamaño
	 * <b>Pre:</b> <br>
	 * recibe el parametro del tamaño de las 2 matrices,<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Regresa el tamaño de la matriz mas grande <br>
	 */
	public int biggerStrassen(int tam1, int tam12, int tam2, int tam21) {
		int mayor =0;
		if(tam1>tam2 &&tam1>tam21) {
			mayor=tam1;
		}else if(tam2>tam1&&tam2>tam21) {
			mayor=tam2;
		}else {
			mayor=tam21;
		}
		boolean flag=false;
		
		while(!flag) {
			if(potencia(mayor)==true) {
				flag=true;
			}else {
				mayor+=1;
			}
		}
		return mayor;
	}
	/**
	 * Metodo que se encarga de calcular la potencia
	 * <b>Pre:</b> <br>
	 * recibe el parametro del numero a calcular<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Regresa la potencia <br>
	 */
	public static boolean potencia(double numero) {
		if(numero==1) {
			return true;
		}else if(numero >1 && numero<2) {
			return false;
		}else if(numero>=2) {
			return potencia(numero/2);
		}
		return false;
	}
	/**
	 * Metodo que se encarga de generar la matriz
	 * <b>Pre:</b> <br>
	 * recibe como parametro el output del metodo biggerStrassen<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Se inicializa la matriz <br>
	 */
	public  void inicializarArr(int mayor) {
		
		A= new long[mayor][mayor];
		B= new long[mayor][mayor];
		C =new long[mayor][mayor];
		for(int i =0;i<mayor;i++) {
			for(int j =0;j<mayor;j++) {
				A[i][j]=0;
			}
		}
		for(int i =0;i<mayor;i++) {
			for(int j =0;j<mayor;j++) {
				B[i][j]=0;
			}
		}
	}
	/**
	 * Metodo que se encarga de asignar los numeros en la matriz
	 * <b>Pre:</b> <br>
	 * recibe como parametro el tamaño de las matrices y los valores de la matriz A y B<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Se inicializa la matriz <br>
	 */
	public  boolean asignar(int tam1,int tam12,int tam2,int tam21,String matrizA, String matrizB) {
		boolean flag=true;
		try {
			for(int i =0;i<tam1;i++) {
				for(int j =0;j<tam12;j++) {
					String filasA= matrizA.split("\n")[i];
					long num=Long.parseLong(filasA.split(" ")[j]) ; 
					A[i][j]=num;
				}
			}
			
			for(int i =0;i<tam2;i++) {
				for(int j =0;j<tam21;j++) {
					String filasB= matrizB.split("\n")[i];
					long num=Long.parseLong(filasB.split(" ")[j]) ; 
					B[i][j]=num;
				}
			}
		}catch (NumberFormatException e) {
			flag=false;
		}
		return flag;
	}
	/**
	 * Metodo que se encarga de multiplicar las matrices utilizando el metodo Strassen
	 * <b>Pre:</b> <br>
	 * recibe como parametro la matriz A y B<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Regresa la matriz R con el reultado <br>
	 */
	public long[][] multiplyStrassen(long[][] A, long[][] B){

		int n = A.length;
        long[][] R = new long[n][n];
        
        if (n == 1) {
            R[0][0] =  (A[0][0] * B[0][0]);
        }else {
            long[][] A11 = new long[n / 2][n / 2];
            long[][] A12 = new long[n / 2][n / 2];
            long[][] A21 = new long[n / 2][n / 2];
            long[][] A22 = new long[n / 2][n / 2];
            long[][] B11 = new long[n / 2][n / 2];
            long[][] B12 = new long[n / 2][n / 2];
            long[][] B21 = new long[n / 2][n / 2];
            long[][] B22 = new long[n / 2][n / 2];
 
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
 
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);
 
 
            long[][] M1 = multiplyStrassen(add(A11, A22), add(B11, B22));
            long[][] M2 = multiplyStrassen(add(A21, A22), B11);
            long[][] M3 = multiplyStrassen(A11, sub(B12, B22));
            long[][] M4 = multiplyStrassen(A22, sub(B21, B11));
            long[][] M5 = multiplyStrassen(add(A11, A12), B22);
            long[][] M6 = multiplyStrassen(sub(A21, A11), add(B11, B12));
            long[][] M7= multiplyStrassen(sub(A12, A22), add(B21, B22));
            long[][] C11 = add(sub(add(M1, M4), M5), M7);
            long[][] C12 = add(M3, M5);
            long[][] C21 = add(M2, M4);
            long[][] C22 = add(sub(add(M1, M3), M2), M6);
            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }
        return R;
    }
	/**
	 * Metodo que se encarga de dividir las matrices en sus sub matrices
	 * <b>Pre:</b> <br>
	 * recibe como parametro la matriz P, C, un entero iB otro jB<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Separa las matrices en sub matrices<br>
	 */
	public void split(long[][] P, long[][] C, int iB, int jB) {
		
        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++) {
                C[i1][j1] = P[i2][j2];
            }
        }
    }
	/**
	 * Metodo que se encarga de sumar las matrices
	 * <b>Pre:</b> <br>
	 * recibe como parametro la matriz A y B<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Suma las matrices<br>
	 */
	public long[][] add(long[][] A, long[][] B){
		 int n = A.length;
	     long[][] C = new long[n][n];
	     
	     for (int i = 0; i < n; i++) {
	    	 for (int j = 0; j < n; j++) {
	    		 C[i][j] = A[i][j] + B[i][j];
	    	 }	 
	     }
	     return C;
	 }
	/**
	 * Metodo que se encarga de restar las matrices 
	 * <b>Pre:</b> <br>
	 * recibe como parametro la matriz A y B<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Resta las matrices<br>
	 */
	public long[][] sub(long[][] A, long[][] B){
	        int n = A.length;
	 
	        long[][] C = new long[n][n];
	 
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                C[i][j] = A[i][j] - B[i][j];
	            }
	        }
	        return C;
	    }
	/**
	 * Metodo que se encarga de unir las sub matrices en una matriz
	 * <b>Pre:</b> <br>
	 * recibe como parametro la matriz C y P y los enteros iB, jB<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Une las matrices las matrices<br>
	 */
	public void join(long[][] C, long[][] P, int iB, int jB){
		 
	        for (int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++) {
	            for (int j1 = 0, j2 = jB; j1 < C.length;j1++, j2++) {
	                P[i2][j2] = C[i1][j1];
	            }
	        }
	    }
	/**
	 * Metodo que se encarga de mostrar el resultdo de la multiplicacion
	 * <b>Pre:</b> <br>
	 * recibe como parametro el tamaño de las dos matrices multiplicadas<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Muestra el resultado de la multiplicacion <br>
	 */
	public String mostrarMatriz(int tam1,int tam12,int tam2,int tam21) {
		String result= "";
		result+="esta es su martiz A: \n";
		for(int i =0;i<tam1;i++) {
			for(int j =0;j<tam12;j++) {
				result+=A[i][j] + " ";
			}
			result+="\n";
		}
		
		result+="\nEsta es su martiz B: \n";
		for(int i =0;i<tam2;i++) {
			for(int j =0;j<tam21;j++) {
				result+=B[i][j] + " ";
			}
			result+="\n";
		}
		
		result+="\nA * B = C \nEsta es su matriz C: \n";
		 for (int i = 0; i < tam1; i++) {
	            for (int j = 0; j < tam21; j++) {
	                result+=C[i][j] + " ";
	            }
	            result+="\n";
	        }
		return result;
	}
	/**
	 * Metodo que se encarga de multiplicar las matrices utilizando el metodo clasico
	 * <b>Pre:</b> <br>
	 * recibe como parametro el tamaño de la matriz mayor<br>
	 * <b>Post:</b> <br>
	 * Se ejecuta el metodo<br>
	 * Regresa la matriz R con el reultado <br>
	 */
	public long[][] multiplyClasic(int mayor) {
		 long[][] R = new long[mayor][mayor];
		for(int i=0;i<mayor;i++) {
			for(int j=0;j<mayor;j++) {
				long sum=0;
				for(int k=0;k<mayor;k++) {
					sum+= A[i][k]*B[k][j];
				}
				R[i][j]=sum;
			}
		}
		return R;
	}
	/**
	 * Getter de la matriz A
	 * @return matriz A
	 */
	public long[][] getA() {
		return A;
	}
	/**
	 * setter de la matriz A
	 */
	public void setA(long[][] a) {
		A = a;
	}
	/**
	 * Getter de la matriz B
	 * @return matriz B
	 */
	public long[][] getB() {
		return B;
	}
	/**
	 * setter de la matriz B
	 */
	public void setB(long[][] b) {
		B = b;
	}
	/**
	 * Getter de la matriz C
	 * @return matriz C
	 */
	public long[][] getC() {
		return C;
	}
	/**
	 * setter de la matriz C
	 */
	public void setC(long[][] c) {
		C = c;
	}
	
}


