package TheSecretHistories.Content.Cards.Starters;

import TheSecretHistories.Content.Cards.Template.TemplateCustomCard;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAndEnableControlsAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.CULT_BLUE;
import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.*;

public class Passion extends TemplateCustomCard {

    public static final String ID = StringUtils.MakeID(Passion.class.getSimpleName());

    private static final int COST = 0;
    private static final CardType TYPE = CardType.SKILL;
    private static final CardColor COLOR = CULT_BLUE;
    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.NONE;

    private static final String IMG_NAME = "passion";

    public Passion() {
        super(ID, IMG_NAME, COST, TYPE, COLOR, RARITY, TARGET);

        this.exhaust = true;

        this.principleTag = MOTH;

        this.tags.add(principleTag);

        this.principleCount = this.basePrincipleCount = 2;

        this.magicNumber = this.baseMagicNumber = 1;
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        this.isInnate = true;

    }

    @Override
    public void use(AbstractPlayer player, AbstractMonster monster) {
        PlayerGainPrinciple();

        addToBot(new GainEnergyAction(magicNumber));
    }
}
