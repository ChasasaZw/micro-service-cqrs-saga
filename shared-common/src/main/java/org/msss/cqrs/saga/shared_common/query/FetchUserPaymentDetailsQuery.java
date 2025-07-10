package org.msss.cqrs.saga.shared_common.query;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class FetchUserPaymentDetailsQuery {

    private String userId;

}
