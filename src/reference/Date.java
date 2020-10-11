package reference;

class Date {
	   int mon;
	   int day;
	   int h, m, s;

	   public Date(String[] day, String[] time) {
	      this.mon = Integer.parseInt(day[0]);
	      this.day = Integer.parseInt(day[1]);
	      this.h = Integer.parseInt(time[0]);
	      this.m = Integer.parseInt(time[1]);
	      this.s = Integer.parseInt(time[2]);

	   }

	   public void minAdd(int min) {
	      if (this.m + min >= 60) {
	         this.m = (this.m + min)%60;
	         hourAdd((this.m + min)/60);
	      } else {
	         this.m += min;
	      }
	   }

	   public void hourAdd(int hour) {
	      if (this.h + hour >= 24) {
	         this.h = (this.h + hour)%24;
	         dayAdd((this.h + hour)/24);
	      } else {
	         this.h += hour;
	      }
	   }

	   public void dayAdd(int day) {
	      int nday = this.day + day;
	      switch (this.mon) {
	      case 1:
	      case 3:
	      case 5:
	      case 7:
	      case 8:
	      case 10:
	      case 12:
	         if (nday > 31) {
	            this.day = nday%31;
	            this.mon += nday/31;
	            return;
	         }
	      case 4:
	      case 6:
	      case 9:
	      case 11:
	         if (nday > 30) {
	            this.day = nday%30;
	            this.mon += nday/31;
	            return;
	         }
	      case 2:
	         if (nday > 28) {
	            this.day = nday%28;
	            this.mon += nday/28;
	            return;
	         }
	      }

	      this.day = nday;
	   }

	   public int compare(Date cd) {
	      // 현재 시간이 빠르면 -1, 비교 시간이 빠르면 1, 같으면 0

	      if (this.mon < cd.mon) {
	         return -1;
	      } else if (this.mon > cd.mon) {
	         return 1;
	      } else {
	         if (this.day < cd.day) {
	            return -1;
	         } else if (this.day > cd.day) {
	            return 1;
	         } else {
	            if (this.h < cd.h) {
	               return -1;
	            } else if (this.h > cd.h) {
	               return 1;
	            } else {
	               if (this.m < cd.m) {
	                  return -1;
	               } else if (this.m > cd.m) {
	                  return 1;
	               } else {
	                  if (this.s < cd.s) {
	                     return -1;
	                  } else if (this.s > cd.s) {
	                     return 1;
	                  } else {
	                     return 0;
	                  }
	               }
	            }
	         }
	      }

	   }
	   public String toString() {
	      return mon+"/"+day+" "+h+":"+m+":"+s;
	   }
	}
