import java.lang.Math;
/** 
 * Program to solve the rod-cutting problem using top down and memoization.
 *
 *@author Erika Yardumian
 *@version 4/11/19
 */
 
public class MemoizedCutRod {
   
   // Driver method to ititiate the recursive procedure.
   static int MEMOIZEDCUTROD(int[] p, int n) {
      int[] r = new int[n + 1];
      for (int i = 0; i < r.length; i++) {
         r[i] = -1;
      }
      return MEMOIZEDCUTRODAUX(p, n, r);
   }
   
   static int MEMOIZEDCUTRODAUX(int[] p, int n, int[] r) {
      int q = -1;
      if (r[n] >= 0) {
         return r[n];
      }
      if (n == 0) {
         q = 0;
      }
      else {
         for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + MEMOIZEDCUTRODAUX(p, n - i - 1, r));
         }
      }
      r[n] = q;
      return q;
   }
   
   // Main method to test the program.
   public static void main (String[] args) {
      MemoizedCutRod test = new MemoizedCutRod();
      int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};          
      for (int i = 0; i < p.length + 1; i++) {        
         System.out.println(MEMOIZEDCUTROD(p, i));
      }
   }
}
