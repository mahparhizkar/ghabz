package com.toranj.ghabz.utils;

/*   */
/*   */ public class GetYearsCeiled implements DurationReturnTypeAlgorithm
        /*   */ {
    /*   */   public int getDuration(Duration duration)
    /*   */   {
        /* 7 */     int years = duration.getNumberOfYears();
        /* 8 */     if ((duration.getNumberOfMonths() > 0) || (duration.getNumberOfDays() > 0)) return years + 1;
        /* 9 */     return years;
        /*   */   }
    /*   */ }

/* Location:           C:\Vger\Maven\Repository\de\novum\vger\technical\technical_frames\6.48.17\technical_frames-6.48.17.jar
 * Qualified Name:     de.novum.vger.technical.technical_frames.date.GetYearsCeiled
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */