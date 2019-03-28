package com.enjaz.debug.logging.presenter;

public interface DashBordPresenterInterface {
    /*
    export message

    * */
    void exportingMessage();

    /*
   Number Of Network Failure

   * */
    void NumberOftNetworkFailure(String type);

    /*
   MaximumTotalMemory

  * */
    void MaximumTotalMemory(String type);

    /*
  ActivityUsage

  * */
    void ActivityUsage(String type);

}
