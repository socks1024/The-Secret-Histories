package TheSecretHistories.Content.Cards.Mansus.OptionCards.MansusLocation;

import com.megacrit.cardcrawl.cards.AbstractCard;

public abstract class AbstractShowedLocation extends AbstractMansusLocation {
    public AbstractShowedLocation(String id, String imgName, AbstractCard[] cards) {
        super(id, imgName, cards);
    }

    @Override
    public void update() {
        super.update();
        if (this.hb.hovered) {
            this.cardsToPreview = chosenCard;
        }
    }
}
