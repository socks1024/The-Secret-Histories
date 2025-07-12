package TheSecretHistories.Content.Actions.UniqueCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import java.util.ArrayList;

public class ToolEdgeFAction extends AbstractGameAction {

    private int damage;

    private int str;

    public ToolEdgeFAction(AbstractCreature source, int damage, int str) {
        this.source = source;
        this.damage = damage;
        this.str = str;
    }

    @Override
    public void update() {
        ArrayList<AbstractMonster> monsters = (AbstractDungeon.getCurrRoom()).monsters.monsters;

        addToTop(new ApplyPowerAction(source, source, new StrengthPower(source, monsters.size() * str)));
        addToTop(new DamageAllEnemiesAction((AbstractPlayer) source, damage, DamageInfo.DamageType.NORMAL, AttackEffect.SLASH_DIAGONAL));

        isDone = true;
    }
}
