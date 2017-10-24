
public class Field {
	private FieldPos[][] fieldpos;
	
	public Field(){
		fieldpos = new FieldPos[15][15];
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				fieldpos[i][j] = new FieldPos(i,j);
			}
		}
	}
	
	public void printStatus(){
		System.out.println("==============================");
		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				if(fieldpos[i][j].getHolder()!=null){
					System.out.print(fieldpos[i][j].getHolder().getName());
				}
				else{
					System.out.print("^^");
				}
			}
			System.out.println();
		}
		System.out.println("==============================");
	}
	
	public FieldPos getFieldPos(int x,int y){
		return fieldpos[x][y];
	}
}

