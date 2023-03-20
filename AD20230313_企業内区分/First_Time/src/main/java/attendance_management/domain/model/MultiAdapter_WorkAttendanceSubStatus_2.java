package attendance_management.domain.model;

import attendance_management.domain.model.workattendance_substatus.Interface_WorkAttendanceSubStatus;
import attendance_management.domain.model.workday_division.WorkDayDivision;
import attendance_management.domain.model.workoffice_division.WorkOfficeDivision;
import attendance_management.domain.model.worktype_division.WorkTypeDivision;

import java.util.ArrayList;
import java.util.List;

enum MultiAdapter_WorkAttendanceSubStatus_2 implements Interface_WorkAttendanceSubStatus {
//      LEVEL_01      ( static_myWorkAttendanceSubStatus_List.stream().toList() )
//    , LEVEL_02     ( static_myWorkAttendanceSubStatus_List2.stream().toList() )
    ;


    private final List<Object>
            myWorkAttendanceSubStatus_Element_List = new ArrayList<>();

    private final List<Object>
            myWorkAttendanceSubStatus_Element_List2 = new ArrayList<>();

    private final List<Object>
            myWorkAttendanceSubStatus_List = new ArrayList<>();

    private final List<Object>
            myWorkAttendanceSubStatus_List2 = new ArrayList<>();

    private static final List<Object>
            static_myWorkAttendanceSubStatus_List = new ArrayList<>();

    private static final List<Object>
            static_myWorkAttendanceSubStatus_List2 = new ArrayList<>();

    //コンストラクターらっしゅ！！
    MultiAdapter_WorkAttendanceSubStatus_2() {


    }

    MultiAdapter_WorkAttendanceSubStatus_2(final Object myWorkAttendanceSubStatus )
    {

        myWorkAttendanceSubStatus_Element_List.add( WorkOfficeDivision.INSIDE);
        myWorkAttendanceSubStatus_Element_List.add( WorkDayDivision.WORKING);
        myWorkAttendanceSubStatus_Element_List.add( WorkTypeDivision.INDOOR);

        myWorkAttendanceSubStatus_List.add(myWorkAttendanceSubStatus_Element_List);

        myWorkAttendanceSubStatus_Element_List2.add( WorkOfficeDivision.OUTSIDE);
        myWorkAttendanceSubStatus_Element_List2.add( WorkDayDivision.NON_WORKING);
        myWorkAttendanceSubStatus_Element_List2.add( WorkTypeDivision.OUTDOOR);

        myWorkAttendanceSubStatus_List2.add(myWorkAttendanceSubStatus_Element_List2);

    }

    //補足説明めそっど:『トランスレーター』へ変換を依頼
    public final String description() { return "hoge"; }

}