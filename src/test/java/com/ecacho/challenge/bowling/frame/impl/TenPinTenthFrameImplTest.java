package com.ecacho.challenge.bowling.frame.impl;

import com.ecacho.challenge.bowling.exception.BowlingException;
import com.ecacho.challenge.bowling.frame.AbstractFrame;
import org.junit.Test;

import static org.junit.Assert.*;

public class TenPinTenthFrameImplTest {

    @Test
    public void perfectStrikeTest() throws BowlingException {
        TenPinTenthFrameImpl f = new TenPinTenthFrameImpl();
        verifyAllRollsWereAdded(f,10, 10, 10);
    }

    @Test
    public void strikeTest() throws BowlingException {
        TenPinTenthFrameImpl f = new TenPinTenthFrameImpl();
        verifyAllRollsWereAdded(f,10, 4, 6);
    }

    @Test
    public void spareTest() throws BowlingException {
        TenPinTenthFrameImpl f = new TenPinTenthFrameImpl();
        verifyAllRollsWereAdded(f,5, 5, 10);
    }

    @Test
    public void foulTest() throws BowlingException {
        TenPinTenthFrameImpl f = new TenPinTenthFrameImpl();
        verifyAllRollsWereAdded(f,0, 0);
    }


    @Test(expected = BowlingException.class)
    public void addInvalidAtFirstRoll() throws BowlingException {
        TenPinTenthFrameImpl f = new TenPinTenthFrameImpl();
        f.addRoll(20);
    }

    @Test(expected = BowlingException.class)
    public void addInvalidAtSecondRoll() throws BowlingException {
        TenPinFrameImpl f = new TenPinFrameImpl(1);
        f.addRoll(4);
        f.addRoll(7);
    }

    @Test(expected = BowlingException.class)
    public void addInvalidAtSecondWhenStrikeRoll() throws BowlingException {
        TenPinFrameImpl f = new TenPinFrameImpl(1);
        f.addRoll(10);
        f.addRoll(11);
    }

    private void verifyAllRollsWereAdded(AbstractFrame f, int... rolls) throws BowlingException {
        int size = rolls.length;
        for (int i = 0; i < size; i++) {
            int roll = rolls[i];
            boolean b = f.addRoll(roll);
            assertTrue("Cannot add roll", b);
        }
        assertTrue("Rolls should be completed", f.isRollsCompleted());
    }
}