package com.toranj.ghabz.utils;

/*    */
/*    */ public class Duration
        /*    */ {
    /*    */   private int numberOfYears;
    /*    */   private int numberOfMonths;
    /*    */   private int numberOfDays;
    /*    */
    /*    */   public Duration(int numberOfYears, int numberOfMonths, int numberOfDays) {
        /* 10 */     this.numberOfYears = numberOfYears;
        /* 11 */     this.numberOfMonths = numberOfMonths;
        /* 12 */     this.numberOfDays = numberOfDays;
        /*    */   }
    /*    */
    /*    */   public Duration(int numberOfYears, int numberOfMonths) {
        /* 16 */     this(numberOfYears, numberOfMonths, 0);
        /*    */   }
    /*    */
    /*    */   public int getNumberOfYears() {
        /* 20 */     return numberOfYears;
        /*    */   }
    /*    */
    /*    */   public int getNumberOfMonths() {
        /* 24 */     return numberOfMonths;
        /*    */   }
    /*    */
    /*    */   public int getNumberOfDays() {
        /* 28 */     return numberOfDays;
        /*    */   }
    /*    */
    /*    */   public String toString()
    /*    */   {
        /* 33 */     return getClass().getName() + "(years: " + numberOfYears + ", months: " + numberOfMonths + ", days: " + numberOfDays + ")";
        /*    */   }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */   public int getDurationPart(DurationReturnType durationReturnType)
    /*    */   {
        /* 41 */     if (durationReturnType == null) return 0;
        /* 42 */     return durationReturnType.getDurationPart(this);
        /*    */   }
    /*    */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.Duration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */