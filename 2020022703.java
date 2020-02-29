 public static List<List<Integer>> subsets(int[] nums) {
        //利用枚举的方法，将数组中的元素一个一个添加，形成幂集
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        for (Integer n:nums) {
            for(int i = 0;i<arr.size();i++){
                ArrayList<Integer> num = new ArrayList<>(arr.get(i));
                num.add(n);
                arr.add(num);
            }
        }
        return arr;
    }