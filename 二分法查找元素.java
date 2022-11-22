 
import java.util.List;
public class Homework4_13 {
        /**
         * Binary Search
         * @param list a sorted List
         * @return the index of `target` (-1 if not found)
         */
  //非递归方法的二分法
        public int search(List<Integer> list, int target) {
            int high = list.size() - 1;
            int low = 0;
            while (high >= low) {
                int mid = low + (high - low) / 2;
                if (list.get(mid) == target) {
                    return mid;
                } else if (list.get(mid) > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return -1;
        }
    /**
     * 二分法查找（二分法查找前的数组必须升序排序）
     * 递归方式
     */

        //测试代码
        public static void main(String[] args) {
            int[] arr ={1,2,3,4,5,6,7,8,8,8,9,10};
            System.out.println(search2(arr,0,arr.length,8));
            int[] arr1 = {1,2,3,4,5,6,7,8,9,10};
            int index = binarySearch(arr1,0,arr1.length - 1,6);
            System.out.println(index);
        }

  //递归法1
        /**
         * 递归方式实现二分法查找
         * @param arr 需要从中查找元素的数组
         * @param min 查找区间数组中起点下标
         * @param max 查找区间数组中终点下标
         * @param num 需要查找的元素
         * @return 如果查找元素存在，返回元素对应数组中的下标，否则返回-1
         */
        private static int search2(int[] arr,int min,int max,int num) {
            //获得查询区间中间数值
            int mid = (max + min) >> 1;
            //如果查询区间中间数值大于查询元素数值，
            if (arr[mid] > num) {
                //那么要查询元素位于中间数值的左边，更新查找区间数组中起点下标
                max = mid - 1;
                //如果查询区间中间数值小于查询元素数值
            }else if (arr[mid] < num) {
                //那么要查询元素位于中间数值的右边，更新查找区间数组中终点下标
                min = mid + 1;
            }else {
                //如果查询区间中间数值等于查询元素数值，那么返回当前数值下标（因为已经找到了）
                return mid;
            }
            //如果查找区间数组中起点下标大于查找区间数组中终点下标，证明查找元素不在查找的区间内，否则递归调用继续查找
            return min > max ? -1 : search2(arr,min,max,num);
        }

//递归法2
        //在数组arr中 L~R区间内进行二分查找搜索
        private static int binarySearch(int[] arr, int L, int R, int key) {
            if(L > R){
                return -1;//元素不存在
            }
            int M = L + (R - L) / 2;
            if(arr[M] == key){
                return M;
            }
            if(arr[M] < key){
                return binarySearch(arr,M+1,R,key);
            }else{
                return binarySearch(arr,L,R-1,key);
            }
        }


}


