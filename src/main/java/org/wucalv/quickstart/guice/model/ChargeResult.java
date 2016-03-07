package org.wucalv.quickstart.guice.model;

/**
 * Created by calvin.wu on 3/1/16.
 */
public interface ChargeResult {

    String getDeclineMessage();

    boolean wasSuccessful();
}
