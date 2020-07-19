import java.util.*;

public class MyClass {

    public static int n,m,v;

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static Queue<Integer> q = new LinkedList<Integer>();
    public static int[] check = new int[1001];
    //Arrays.fill(check, false);

    public static void dfs(int x){
        if(check[x] == 1) return;

        System.out.print(x+" ");
        check[x] = 1;
        for(int i=0;i<list.get(x).size();i++){
            int y = list.get(x).get(i);
            dfs(y);
        }
    }

    public static void bfs(int x){
        if(check[x] != 1) {
            System.out.print(x + " ");
            check[x] = 1;
            for (int i = 0; i < list.get(x).size(); i++) {
                int y = list.get(x).get(i);
                q.offer(y);
            }
        }
        if(q.isEmpty()) return;
        bfs(q.poll());

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for(int i=0; i<=n;i++)
            list.add(new ArrayList<Integer>());

        for(int i=0;i<m;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for(int i = 0; i < n; i++) {
            Collections.sort(list.get(i));
        }

        dfs(v);
        System.out.println();
        Arrays.fill(check, 0);
        bfs(v);


    }

}
