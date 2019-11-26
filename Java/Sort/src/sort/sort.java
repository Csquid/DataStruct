package sort;

public class sort {
	long timeStart = 0;
	long timeEnd   = 0;
	double timeResult = 0;
	//long start = System.currentTimeMillis(); //시작하는 시점 계산
	/*
	실행시간을 측정하고싶은 코드


	long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
	System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력
	*/

    public int[] BubbleSort(int[] nArr) {
        for (int i = 0; i < nArr.length; i++) {
            for (int j = 0; j < nArr.length - i; j++) {
                if (nArr[j] != nArr[nArr.length - (i + 1)]) {
                    if (nArr[j] > nArr[j + 1]) {
                        this.SWAP(nArr, j + 1, j);
                    }
                }
            }
        }

        return nArr;
    }

    public int[] SelectSort(int[] nArr) {
        for (int i = 0; i < nArr.length; i++) {
            int min = nArr[i];
            int min_index = i;
            for (int j = i; j < nArr.length; j++) {
                //제일 작은 수가 nArr[j]보다 크다면 nArr[j]가 더 크다.
                if (min > nArr[j]) {
                    min = nArr[j];
                    min_index = j;
                }
            }
            this.SWAP(nArr, min_index, i);
        }

        return null;
    }

    public int[] InsertionSort(int[] nArr) {
        int currentIndex = 1;
        int compareIndex = 0;
        int tempIndex = currentIndex;                //현재 인덱스를 임시로 담아두는 변수

        for (int i = 0; i < nArr.length; i++) {
        	if(tempIndex != nArr.length) {
				currentIndex = tempIndex;
				tempIndex++;
			}
            compareIndex = currentIndex - 1;

            while (compareIndex != -1) {
                if (nArr[compareIndex] > nArr[currentIndex]) {
                    SWAP(nArr, currentIndex, compareIndex);
                    currentIndex--;
                    compareIndex = currentIndex - 1;
                } else {
                    compareIndex = -1;
                }
            }
        }


        return null;
    }

    public void SWAP(int nArr[], int x, int y) {
        int temp = nArr[x];
        nArr[x] = nArr[y];
        nArr[y] = temp;
    }

    public void StartSortParty(int[] nArr) {
        int[] tempArr = new int[nArr.length];

        System.out.print("Sort Before: ");
        this.ShowArr(nArr);
        System.out.println("\n");
        LoopSort(nArr, tempArr, 3);
    }

    public void LoopSort(int[] nArr, int[] tempArr, int loopCount) {
        for (int i = 0; i < loopCount; i++) {
            System.arraycopy(nArr, 0, tempArr, 0, tempArr.length);
			checkRunTimeStart();
            switch (i) {
                case 0:
                    this.BubbleSort(tempArr);
                    System.out.print("Bubble Sort: ");
                    break;
                case 1:
                    this.SelectSort(tempArr);
                    System.out.print("Select Sort: ");
                    break;
                case 2:
                    this.InsertionSort(tempArr);
                    System.out.print("Insertion Sort: ");
                    break;
            }
			checkRunTimeEnd();
			this.ShowArr(tempArr);
			System.out.println();
			showRunTimeResult();
			System.out.println();

        }
    }

    public void ShowArr(int[] nArr) {
        for (int i = 0; i < nArr.length; i++) {
            System.out.print(nArr[i] + " ");
        }
    }

	public void checkRunTimeStart() {
		timeStart = System.currentTimeMillis(); //시작하는 시점 계산
	}
	public void checkRunTimeEnd() {
		timeEnd = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		timeResult = ( timeEnd - timeStart ) / 100.0;
	}
	public void showRunTimeResult() {
		System.out.println("실행 시간 : " + getTimeResult() +"초");
	}

	//프로그램 돌아가는 시간 측정
	public double getTimeResult() {
		return timeResult;
	}
}
