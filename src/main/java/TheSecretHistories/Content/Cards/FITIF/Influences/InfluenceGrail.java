package TheSecretHistories.Content.Cards.FITIF.Influences;

import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.ArtifactPower;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.GRAIL;

public class InfluenceGrail extends AbstractInfluences {

    public static String ID = StringUtils.MakeID(InfluenceGrail.class.getSimpleName());

    public static CardTags PRINCIPLE_TAG = GRAIL;

    public InfluenceGrail() {
        super(ID, PRINCIPLE_TAG);

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        super.use(abstractPlayer, abstractMonster);

        addToBot(new ApplyPowerAction(abstractPlayer, abstractPlayer, new ArtifactPower(abstractPlayer, magicNumber)));
    }
}
