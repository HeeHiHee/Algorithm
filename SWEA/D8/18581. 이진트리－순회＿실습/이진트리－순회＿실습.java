import java.util.Scanner;

public class Solution {
	public static int[] tree;
	public static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 트리의 정점의 총 수
		int V = sc.nextInt(); // 13

		// 0~23번까지 총 24칸
		// arr.length = 24
		int[] arr = new int[2 * (V - 1)];

		// 배열에 값 넣기
		// 0~23번까지 총 24칸
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 트리의 높이를 찾기 위한 배열 생성
		// 0~13번까지 총 14칸
		// treeDep.length = 14
		int[] treeDep = new int[V + 1];

		// treeDep 배열에 해당 인덱스(자식)의 부모 값을 넣는다.
		// key:자식, value:부모
		// 13의 부모는 11
		for (int i = 2; i < treeDep.length; i++) {
			treeDep[i] = arr[(i - 2) * 2];
		}

		// 트리 높이 찾기
		int h = 0; // 트리 높이+1을 저장하기위한 변수
		int t = treeDep.length - 1; // 14-1=13
		int tmp = 0;
		// t가 0이면 stop
		while (t != 0) {
			tmp = treeDep[t];
			t = tmp;
			h++;
		}

		// 찐 트리 배열 만들기
		N = (int) Math.pow(2, h); // 2의 h승
		tree = new int[N]; // 0~31번까지 총 32칸

		// 트리 만들기
		int idx = 0;
		// i값이 0~13으로 트리 배열에 value로 넣을 값
		for (int i = 0; i < treeDep.length; i++) {
			// i가 1보다 작거나 같으면 i번 인덱스에 i값 넣기
			if (i <= 1) {
				tree[i] = i;
			} else {
				// treeDep에서 i의 값(i의 부모값)이랑 tree의 value랑 같을 때 tree의 해당 인덱스를 저장
				for (int j = 0; j < tree.length; j++) {
					if (tree[j] == treeDep[i]) {
						idx = j;
					}
				}
				// tree 배열에서 idx의 2배한 인덱스 자리에 값이 비어있으면(0이면) i 넣기
				if (tree[idx * 2] == 0) {
					tree[idx * 2] = i;
				} else {
					// 자리가 차있으면 다음 자리에 i 넣기
					tree[idx * 2 + 1] = i;
				}
			}
		}


		// 전위 순회
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);

	}// main

	// 전위 순회
	public static void preorder(int i) { // i : 현재 방문하고 있는 노드 번호
		// 유효한 노드인지는 어떻게 쳌?
		if (i < N) {
			if (tree[i] != 0) {
				System.out.print(tree[i] + " "); // V
			}
			preorder(i * 2); // L
			preorder(i * 2 + 1); // R

		}

	}

	// 중위 순회
	public static void inorder(int i) {
		// 유효한 노드인지는 어떻게 쳌?
		if (i < N) {
			inorder(i * 2); // L
			if (tree[i] != 0)
				System.out.print(tree[i] + " "); // V
			inorder(i * 2 + 1); // R
		}
	}

	// 후위 순회
	public static void postorder(int i) {
		// 유효한 노드인지는 어떻게 쳌?
		if (i < N) {
			postorder(i * 2); // L
			postorder(i * 2 + 1); // R
			if (tree[i] != 0)
				System.out.print(tree[i] + " "); // V
		}
	}

}