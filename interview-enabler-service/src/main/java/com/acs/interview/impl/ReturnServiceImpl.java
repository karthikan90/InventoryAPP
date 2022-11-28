package com.acs.interview.impl;

import com.acs.interview.EmployeeService;
import com.acs.interview.repo.EmployeeRepository;
import com.acs.interview.request.ReasonData;
import com.acs.interview.request.ReasonDetails;
import com.acs.interview.response.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReturnServiceImpl  {

    static List<Map<String, ReasonDetails>> reasons;

    static {

        //Product Issues
        final List<ReasonData> productIssues = List.of(getReasonInfo("MISUNDERSTOOD_IMAGE", "MISUNDERSTOOD_IMAGE_CODE"),
                getReasonInfo("COLOR_MISMATCH", "COLOR_MISMATCH_CODE"),
                getReasonInfo("QUALITY_ISSUE", "QUALITY_ISSUE_CODE"),
                getReasonInfo("ITEM_NOT_FIT", "ITEM_NOT_FIT_CODE"));
        final ReasonDetails productIssuesChildren = ReasonDetails.builder().children(productIssues).build();
        final Map<String, ReasonDetails> productNotExpectations = Map.of("PRODUCT_DID_NOT_MEET_EXPECTATIONS", productIssuesChildren);

        //Shipment problem
        final Map<String, List<ReasonData>> shipmentNeverDelivered = Map.of("SHIPMENT_NEVER_DELIVERED", List.of(
                getReasonInfo("CARRIER_DELIVEREDTO_WRONG_ADDRESS", "CARRIER_DELIVEREDTO_WRONG_ADDRESS_CODE"),
                getReasonInfo("CUSTOMER_PROVIDED_WRONG_ADDRESS", "CUSTOMER_PROVIDED_WRONG_ADDRESS_CODE"),
                getReasonInfo("DELIVERED_BUT_MISSING", "DELIVERED_BUT_MISSING_CODE"),
                getReasonInfo("INVALID_TRACKING", "INVALID_TRACKING_CODE"),
                getReasonInfo("RETURN_TO_SENDER", "RETURN_TO_SENDER_CODE"),
                getReasonInfo("TRACKING_INCOMPLETE", "TRACKING_INCOMPLETE_CODE")
        ));

        final List<ReasonData> shipmentProbChildrens = List.of(//shipmentNeverDelivered,
                getReasonInfo("RECEIVED_WRONG_ITEM", "RECEIVED_WRONG_ITEM_CODE"),
                getReasonInfo("ORDER_ARRIVED_INCOMPLETE", "ARRIVED_INCOMPLETE_CODE"),
                getReasonInfo("MISSING_PART", "MISSING_PART_CODE"),
                getReasonInfo("ARRIVED_LATE", "ARRIVED_LATE_CODE"),
                getReasonInfo("NOT_MY_ORDER", "NOT_MY_ORDER_CODE"));

        final ReasonDetails shipmentProblems = ReasonDetails.builder().children(shipmentProbChildrens).build();

        final Map<String, ReasonDetails> shipmentProblem = Map.of("SHIPMENT_PROBLEM", shipmentProblems);

        //product/item damaged
        final List<ReasonData> damageReasons = List.of(
                getReasonInfo("MANUFACTURE_DEFECT", "MANUFACTURE_DEFECT_CODE"),
                getReasonInfo("DAMAGED_IN_TRANSIT", "DAMAGED_IN_TRANSIT_CODE"));

        final ReasonDetails damageChildren = ReasonDetails.builder().children(damageReasons).build();

        final Map<String, ReasonDetails> productDamaged = Map.of("PACKAGE_WAS_DAMAGED", damageChildren);
//        reasons = List.of(getReasonInfo("CHANGED_MY_MIND", "CHANGED_MY_MIND_CODE"),
//                productNotExpectations,
//                getReasonInfo("BETTER_PRICE_ELSEWHERE", "BETTER_PRICE_ELSEWHERE_CODE"),
//                shipmentProblem,
//                productDamaged);
    }

    public void test () {
        List<ReasonDetails> reasons = new ArrayList<>();
    }

    public static ReasonData getReasonInfo(String displayName, String code) {
        return ReasonData.builder().displayName(displayName).code(code).build();
    }
}
