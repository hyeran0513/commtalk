package com.commtalk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "engagement_actions")
public class EngagementAction {

	@Column(name = "action_id")
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "action_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private ActionType action;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
	private Member member;

	@Column(name = "ref_id")
	private Long refId;
	
	public enum ActionType {
	    plike, clike, scrap
	}

	public EngagementAction() {
	}

	public EngagementAction(Member member, Long refId, ActionType action) {
		this.member = member;
		this.refId = refId;
		this.action = action;
	}
	
}
