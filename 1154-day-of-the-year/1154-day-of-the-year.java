class Solution {
    public int dayOfYear(String date) {
        String [] a = date.split("-");
        int y = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);
        int d = Integer.parseInt(a[2]);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)) {
            days[1] = 29;
        }
        int totalDays = d;
        for (int i = 0; i < m - 1; i++) {
            totalDays += days[i];
        }

        return totalDays;
    }
}