package com.amatsuka.notification.contract;

/**
 * Интерфейс сервиса регистрации отправленных уведомлений
 */
public interface FiredNotificationService {
    /**
     * Возвращает true если уведомление уже было зарегистрировано как отправленное
     *
     * @param notification Объект уведомления
     * @return boolean
     */
    boolean notificationIsFired(Notification notification);

    /**
     * Региструет уведомление как отправленное
     *
     * @param notification Объект уведомления
     */
    void addNotification(Notification notification);
}
