package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.HEART;

public class InfluenceHeart extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceHeart.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = HEART;

    public InfluenceHeart() {
        super(ID, PRINCIPLE_TAG);

        this.block = this.baseBlock = 2;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        super.OnUpgrade(timesUpgraded);
        upgradeDamage(GetPrincipleIncrease(timesUpgraded));
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new GainBlockAction(abstractPlayer, block));
    }
}
