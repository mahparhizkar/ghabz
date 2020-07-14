package com.toranj.ghabz.utils;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public enum DurationReturnType
        /*    */ {
    /* 11 */   YEARS(new GetYears()),
    /*    */
    /*    */
    /*    */
    /* 15 */   YEARS_CEILED(new GetYearsCeiled()),
    /*    */
    /*    */
    /*    */
    /* 19 */   YEARS_HALF_UP(new GetYearsHalfUp()),
    /*    */
    /*    */
    /*    */
    /* 23 */   REST_MONTHS(new GetRestMonths()),
    /*    */
    /*    */
    /*    */
    /* 27 */   REST_MONTHS_CEILED(new GetRestMonthsCeiled()),
    /*    */
    /*    */
    /*    */
    /* 31 */   REST_DAYS(new GetRestDays());
    /*    */
    /*    */   private final DurationReturnTypeAlgorithm durationReturnTypeAlgorithm;
    /*    */
    /*    */   private DurationReturnType(DurationReturnTypeAlgorithm durationReturnTypeAlgorithm) {
        /* 36 */     this.durationReturnTypeAlgorithm = durationReturnTypeAlgorithm;
        /*    */   }
    /*    */
    /*    */   public int getDurationPart(Duration duration) {
        /* 40 */     return durationReturnTypeAlgorithm.getDuration(duration);
        /*    */   }
    /*    */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.DurationReturnType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */