public class Battle {
      public static final int N = 12;
      private Position [][]positions;
      Battle()
      {
           positions = new Position[N][N];
           int i, j;
           for(i = 0; i < N; i++)
               for(j = 0; j < N; j++)
               {
                    positions[i][j] = new Position(i, j);
               }
      }
      public Position getPosition(int x, int y)
      {
           return positions[x][y];
      }


      public void AddGrandpa(Creature leader)
      {
          //Position position=new Position(4,3);
          positions[1][2].setHolder(leader);
          leader.setPos(positions[1][2]);
      }

      public void AddSnake(Creature leader)
      {
         // Position position=new Position(4,4);
          positions[1][7].setHolder(leader);
          leader.setPos(positions[1][7]);
      }

     public void show()
     {
           int i,j ;
           for( i = 0; i < N; i++)
           {
                for (j = 0; j < N; j++)
               {
                 if (positions[i][j].occupy())
                 {
                     positions[i][j].getHolder().report();
                  }
                  else
                 {
                     System.out.print("  ");
                 }
                  System.out.print("\t");
               }
                  System.out.println();
          }
     }

     public void clear() {
         int i, j;
         for (i = 0; i < N; i++) {
             for (j = 0; j < N; j++) {
                 if (positions[i][j].occupy()) {
                     positions[i][j].CreatureOut();


                 }

             }
         }
     }

}
