class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] a= Arrays.copyOf(arr,n);
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(a);
        int rank=1;
        for(int i=0;i<n;i++){
            map.put(a[i],rank);
            while(i<n-1 && a[i+1]==a[i]){
                 map.put(a[i+1],rank);
                 i++;
            }
            rank++;
        }
        for(int i=0;i<n;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}