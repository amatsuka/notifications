package com.amatsuka.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationFactory {
    private final SmsMessageGenerator smsMessageGenerator;
    private final UserAccService userAccService;
    private final MessagesResourceService messagesResourceService;

    public NewOperationUserNotification newOperationUserNotification(UserAccDto user, CommitOperationAnswerDto operation) {
        return new NewOperationUserNotification(user, operation, smsMessageGenerator);
    }

    public DealerIndividualRatesListUpdatedNotification dealerIndividualRatesListUpdatedNotification(long requestsCount) {
        return new DealerIndividualRatesListUpdatedNotification().setRequestsCount(requestsCount);
    }

    public IndividualRateConfirmedNotification individualRateConfirmedNotification(UserAccAdminDto user, IndividualRateSocketDto request) {
        return new IndividualRateConfirmedNotification(user, request);
    }

    public IndividualRateRejectNotification individualRateRejectNotification(UserAccAdminDto user, IndividualRateSocketDto request) {
        return new IndividualRateRejectNotification(user, request);
    }

    public CancelOperationByClientNotification cancelByClientOperationUserNotification(UserAccDto user, OperationDto operationDto) {
        return new CancelOperationByClientNotification(user, operationDto, smsMessageGenerator);
    }

    public CancelOperationBySystemNotification cancelBySystemOperationUserNotification(UserAccDto user, OperationDto operationDto) {
        return new CancelOperationBySystemNotification(user, operationDto, smsMessageGenerator);
    }

    public OperationWillBeExpiredUserNotification operationWillBeExpiredUserNotification(UserAccDto user, OperationDto operationDto) {
        return new OperationWillBeExpiredUserNotification(user, operationDto, smsMessageGenerator);
    }

    public NewUserAgreementToAllClientsNotification newUserAgreementToAllClientsNotification(AgreementDto licenseAgreement) {
        return new NewUserAgreementToAllClientsNotification(userAccService, messagesResourceService, licenseAgreement);
    }

    public NewTariffToAllClientsNotification newTariffToAllClientsNotification(TariffDocumentDto tariff) {
        return new NewTariffToAllClientsNotification(userAccService, messagesResourceService, tariff);
    }

    public LimitThresholdReachedDealerNotification limitThresholdReachedDealerNotification(int count) {
        return new LimitThresholdReachedDealerNotification().setCount(count);
    }

    public LimitThresholdReachedDealerSmsNotification limitThresholdReachedDealerSmsNotification(DutyDealerDto dealer, LimitCurrencyDto limit) {
        return new LimitThresholdReachedDealerSmsNotification(dealer, limit, smsMessageGenerator);
    }


    public LimitThresholdReachedAdminNotification limitThresholdReachedAdminNotification(int count) {
        return new LimitThresholdReachedAdminNotification().setCount(count);
    }

    public NewImportantNewsToAllClientsNotification newImportantNewsToAllClientsNotification(NewsDto news) {
        return new NewImportantNewsToAllClientsNotification(userAccService, messagesResourceService, news);
    }
}
