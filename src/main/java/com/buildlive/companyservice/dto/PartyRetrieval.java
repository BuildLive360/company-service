package com.buildlive.companyservice.dto;

import com.buildlive.companyservice.entity.library.PartyMember;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyRetrieval {

    List<PartyMember> partyMembers;
}
