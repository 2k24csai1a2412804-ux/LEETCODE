class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] sorted= Arrays.copyOf(arr,n);
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(sorted);
        int rank=1;
        for(int i=0;i<n;i++){
            map.put(sorted[i],rank);
            while(i<n-1 && sorted[i+1]==sorted[i]){
                 map.put(sorted[i+1],rank);
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