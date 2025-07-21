package TheSecretHistories.Content.Cards.FITIF.Followers;

import TheSecretHistories.Content.Cards.Rites.NormalRites.RiteFollowerConsumeInfluence;
import TheSecretHistories.Content.Cards.Rites.NormalRites.RiteInfluenceConsumeIngredient;
import TheSecretHistories.Content.Cards.Rites.NormalRites.RiteToolConsumeFollower;
import TheSecretHistories.Content.Cards.Rites.NormalRites.RiteToolConsumeIngredient;
import TheSecretHistories.Content.Cards.Rites.SummonRites.*;
import TheSecretHistories.Utils.DeckUtils;
import TheSecretHistories.Utils.StringUtils;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.utility.DiscardToHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Random;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerTagEnum.KNOCK;

public class FollowerKnockEnid extends AbstractFollower{

    public static final String ID = StringUtils.MakeID(FollowerKnockEnid.class.getSimpleName());
    private static final String IMG_NAME = "enid_a";
    private static final int COST = 2;
    private static final CardType TYPE = CardType.ATTACK;
    public static CardTags PRINCIPLE_TAG = KNOCK;
    private static final CardRarity RARITY = CardRarity.UNCOMMON;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    private static final AbstractCard[] RITES = new AbstractCard[] {
            new RiteConsumeAll(),
            new RiteInfluenceConsumeFollower(),
            new RiteFollowerConsumeIngredient(),
            new RiteFollowerConsumeInfluence(),
            new RiteInfluenceConsumeIngredient(),
            new RiteToolConsumeFollower(),
            new RiteToolConsumeIngredient(),
            new RiteFollowerConsumeIngredient(),
            new RiteFollowerConsumeTool(),
            new RiteToolFollowerConsumeLore(),
    };

    public FollowerKnockEnid() {
        super(ID, IMG_NAME, COST, TYPE, RARITY, TARGET, PRINCIPLE_TAG);
        this.damage = this.baseDamage = 16;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.use(p, m);
        addToBot(new DamageAction(m, new DamageInfo(p, damage)));
        addToBot(new MakeTempCardInHandAction(RITES[new Random().nextInt(RITES.length)].makeCopy()));
    }

    @Override
    protected void OnUpgrade(int timesUpgraded) {
        upgradeDamage(6);
    }
}