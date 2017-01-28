package com.ilargia.games.core;

import com.ilargia.games.entitas.matcher.Matcher;

/**
 * ---------------------------------------------------------------------------
 * '<auto-generated>' This code was generated by CodeGeneratorApp.
 * ---------------------------------------------------------------------------
 */
public class CoreMatcher {

	private static Matcher _matcherAsset;
	private static Matcher _matcherDestroy;
	private static Matcher _matcherGameBoard;
	private static Matcher _matcherGameBoardElement;
	private static Matcher _matcherInteractive;
	private static Matcher _matcherMovable;
	private static Matcher _matcherPosition;
	private static Matcher _matcherView;

	public static Matcher Asset() {
		if (_matcherAsset == null) {
			Matcher matcher = (Matcher) Matcher.AllOf(CoreComponentIds.Asset);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherAsset = matcher;
		}
		return _matcherAsset;
	}

	public static Matcher Destroy() {
		if (_matcherDestroy == null) {
			Matcher matcher = (Matcher) Matcher.AllOf(CoreComponentIds.Destroy);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherDestroy = matcher;
		}
		return _matcherDestroy;
	}

	public static Matcher GameBoard() {
		if (_matcherGameBoard == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentIds.GameBoard);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherGameBoard = matcher;
		}
		return _matcherGameBoard;
	}

	public static Matcher GameBoardElement() {
		if (_matcherGameBoardElement == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentIds.GameBoardElement);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherGameBoardElement = matcher;
		}
		return _matcherGameBoardElement;
	}

	public static Matcher Interactive() {
		if (_matcherInteractive == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentIds.Interactive);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherInteractive = matcher;
		}
		return _matcherInteractive;
	}

	public static Matcher Movable() {
		if (_matcherMovable == null) {
			Matcher matcher = (Matcher) Matcher.AllOf(CoreComponentIds.Movable);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherMovable = matcher;
		}
		return _matcherMovable;
	}

	public static Matcher Position() {
		if (_matcherPosition == null) {
			Matcher matcher = (Matcher) Matcher
					.AllOf(CoreComponentIds.Position);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherPosition = matcher;
		}
		return _matcherPosition;
	}

	public static Matcher View() {
		if (_matcherView == null) {
			Matcher matcher = (Matcher) Matcher.AllOf(CoreComponentIds.View);
			matcher.componentNames = CoreComponentIds.componentNames();
			_matcherView = matcher;
		}
		return _matcherView;
	}
}