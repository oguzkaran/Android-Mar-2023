package org.csystem.app.chatsystem.service.dto;

public class ResultMessage<T>
{
    private final T m_data;
    private final String m_message;
    private final boolean m_success;

    public ResultMessage(String message, boolean success, T data)
    {
        m_data = data;
        m_message = message;
        m_success = success;
    }

    public T getData()
    {
        return m_data;
    }

    public String getMessage()
    {
        return m_message;
    }

    public boolean isSuccess()
    {
        return m_success;
    }
}