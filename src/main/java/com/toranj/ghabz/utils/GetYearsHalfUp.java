package com.toranj.ghabz.utils;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class GetYearsHalfUp
        /*    */   implements DurationReturnTypeAlgorithm
        /*    */ {
    /*    */   public int getDuration(Duration duration)
    /*    */   {
        /* 13 */     int years = duration.getNumberOfYears();
        /* 14 */     if (duration.getNumberOfMonths() < 6) return years;
        /* 15 */     if ((duration.getNumberOfMonths() == 6) && (duration.getNumberOfDays() == 0)) return years;
        /* 16 */     return years + 1;
        /*    */   }
    /*    */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.GetYearsHalfUp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */