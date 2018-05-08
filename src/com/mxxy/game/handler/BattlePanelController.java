package com.mxxy.game.handler;

import java.awt.event.MouseEvent;

import com.mxxy.game.listener.AbstractBaseEventListener;
import com.mxxy.game.sprite.Players;
import com.mxxy.game.ui.BattlePanel;
/**
 * @author ZAB
 * 邮箱 ：624284779@qq.com
 */
public class BattlePanelController extends AbstractBaseEventListener<BattlePanel>{

	public BattlePanelController(BattlePanel gamePanel) {
		mPanel = gamePanel;
		mPanel.setListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Players clickPlayer = null;
		// 是否点击在敌方单位上
		for (int i = 0; i < mPanel.getHostileTeam().size(); i++) {
			Players p = mPanel.getHostileTeam().get(i);
			if (p.contains(x - p.getX(), y - p.getY())) {
				clickPlayer = p;
				break;
			}
		}
		if(mPanel.isWaitingCmd() && clickPlayer!=null) {
			mPanel.setTarget(clickPlayer);
			if (mPanel.isSelectMagic()) {
				mPanel.setSelectMagic(false);
//				if (selectedMagic != null) {
					mPanel.magicCmd();
//				}
			} else {
				mPanel.attackCmd();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}