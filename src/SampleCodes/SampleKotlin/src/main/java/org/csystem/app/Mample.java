package org.csystem.app;

class Mample {
    private int m_value;
    private boolean m_filled;

    public int getValue()
    {
        return m_value;
    }

    public boolean isFilled() {return m_filled;}

    public void setFilled(boolean filled)
    {
        m_filled = filled;
    }

    public void setValue(int value)
    {
        m_value = value;
    }
}
