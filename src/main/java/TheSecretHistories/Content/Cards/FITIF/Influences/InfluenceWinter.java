package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.WINTER;

public class InfluenceWinter extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceWinter.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = WINTER;

    public InfluenceWinter() {
        super(ID, PRINCIPLE_TAG);

        this.damage = this.baseDamage = 4;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, damage), AbstractGameAction.AttackEffect.SMASH));
    }
}
