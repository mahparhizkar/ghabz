package com.toranj.ghabz.utils;

/*   */
/*   */ public class GetRestMonthsCeiled implements DurationReturnTypeAlgorithm
        /*   */ {
    /*   */   public int getDuration(Duration duration)
    /*   */   {
        /* 7 */     int months = duration.getNumberOfMonths();
        /* 8 */     if (duration.getNumberOfDays() > 0) return months + 1;
        /* 9 */     return months;
        /*   */   }
    /*   */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.GetRestMonthsCeiled
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */