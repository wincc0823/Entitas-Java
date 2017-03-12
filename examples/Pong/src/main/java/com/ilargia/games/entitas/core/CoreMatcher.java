package com.ilargia.games.entitas.core;

import com.ilargia.games.entitas.matcher.Matcher;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class CoreMatcher {

	private static Matcher _matcherBall;
	private static Matcher _matcherDelay;
	private static Matcher _matcherMotion;
	private static Matcher _matcherPlayer;
	private static Matcher _matcherScore;
	private static Matcher _matcherTextureView;
	private static Matcher _matcherView;

	public static Matcher Ball() {
		if (_matcherBall == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.Ball);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherBall = matcher;
		}
		return _matcherBall;
	}

	public static Matcher Delay() {
		if (_matcherDelay == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.Delay);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherDelay = matcher;
		}
		return _matcherDelay;
	}

	public static Matcher Motion() {
		if (_matcherMotion == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.Motion);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherMotion = matcher;
		}
		return _matcherMotion;
	}

	public static Matcher Player() {
		if (_matcherPlayer == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.Player);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherPlayer = matcher;
		}
		return _matcherPlayer;
	}

	public static Matcher Score() {
		if (_matcherScore == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.Score);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherScore = matcher;
		}
		return _matcherScore;
	}

	public static Matcher TextureView() {
		if (_matcherTextureView == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.TextureView);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherTextureView = matcher;
		}
		return _matcherTextureView;
	}

	public static Matcher View() {
		if (_matcherView == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentsLookup.View);
			matcher.componentNames = CoreComponentsLookup.componentNames();
			_matcherView = matcher;
		}
		return _matcherView;
	}
}